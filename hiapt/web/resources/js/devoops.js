//
//    Main script of DevOOPS v1.0 Bootstrap Theme
//
"use strict";
/*-------------------------------------------
	Dynamically load plugin scripts
---------------------------------------------*/
//
// Dynamically load Fullcalendar Plugin Script
// homepage: http://arshaw.com/fullcalendar
// require moment.js
//
function LoadCalendarScript(callback){
	function LoadFullCalendarScript(){
		if(!$.fn.fullCalendar){
			$.getScript('/hiapt/resources/fullcalendar/fullcalendar.js', callback);
		}
		else {
			if (callback && typeof(callback) === "function") {
				callback();
			}
		}
	}
	if (!$.fn.moment){
		$.getScript('/hiapt/resources/js/moment.min.js', LoadFullCalendarScript);
	}
	else {
		LoadFullCalendarScript();
	}
}


/*-------------------------------------------
	Main scripts used by theme
---------------------------------------------*/
//
//  Function for load content from url and put in $('.ajax-content') block
//
function LoadAjaxContent(url){
	$('.preloader').show();
	$.ajax({
		mimeType: 'text/html; charset=utf-8', // ! Need set mimeType only when run from local file
		url: url,
		type: 'GET',
		success: function(data) {
			$('#ajax-content').html(data);
			$('.preloader').hide();
		},
		error: function (jqXHR, textStatus, errorThrown) {
			alert(errorThrown);
		},
		dataType: "html",
		async: false
	});
}
//
//  Function maked all .box selector is draggable, to disable for concrete element add class .no-drop
//
function WinMove(){
	$( "div.box").not('.no-drop')
		.draggable({
			revert: true,
			zIndex: 2000,
			cursor: "crosshair",
			handle: '.box-name',
			opacity: 0.8
		})
		.droppable({
			tolerance: 'pointer',
			drop: function( event, ui ) {
				var draggable = ui.draggable;
				var droppable = $(this);
				var dragPos = draggable.position();
				var dropPos = droppable.position();
				draggable.swap(droppable);
				setTimeout(function() {
					var dropmap = droppable.find('[id^=map-]');
					var dragmap = draggable.find('[id^=map-]');
					if (dragmap.length > 0 || dropmap.length > 0){
						dragmap.resize();
						dropmap.resize();
					}
					else {
						draggable.resize();
						droppable.resize();
					}
				}, 50);
				setTimeout(function() {
					draggable.find('[id^=map-]').resize();
					droppable.find('[id^=map-]').resize();
				}, 250);
			}
		});
}
//
// Swap 2 elements on page. Used by WinMove function
//
jQuery.fn.swap = function(b){
	b = jQuery(b)[0];
	var a = this[0];
	var t = a.parentNode.insertBefore(document.createTextNode(''), a);
	b.parentNode.insertBefore(a, b);
	t.parentNode.insertBefore(b, t);
	t.parentNode.removeChild(t);
	return this;
};

//
//  Screensaver function
//  used on locked screen, and write content to element with id - canvas
//
function ScreenSaver(){
	var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	// Size of canvas set to fullscreen of browser
	var W = window.innerWidth;
	var H = window.innerHeight;
	canvas.width = W;
	canvas.height = H;
	// Create array of particles for screensaver
	var particles = [];
	for (var i = 0; i < 25; i++) {
		particles.push(new Particle());
	}
	function Particle(){
		// location on the canvas
		this.location = {x: Math.random()*W, y: Math.random()*H};
		// radius - lets make this 0
		this.radius = 0;
		// speed
		this.speed = 3;
		// random angle in degrees range = 0 to 360
		this.angle = Math.random()*360;
		// colors
		var r = Math.round(Math.random()*255);
		var g = Math.round(Math.random()*255);
		var b = Math.round(Math.random()*255);
		var a = Math.random();
		this.rgba = "rgba("+r+", "+g+", "+b+", "+a+")";
	}
	// Draw the particles
	function draw() {
		// re-paint the BG
		// Lets fill the canvas black
		// reduce opacity of bg fill.
		// blending time
		ctx.globalCompositeOperation = "source-over";
		ctx.fillStyle = "rgba(0, 0, 0, 0.02)";
		ctx.fillRect(0, 0, W, H);
		ctx.globalCompositeOperation = "lighter";
		for(var i = 0; i < particles.length; i++){
			var p = particles[i];
			ctx.fillStyle = "white";
			ctx.fillRect(p.location.x, p.location.y, p.radius, p.radius);
			// Lets move the particles
			// So we basically created a set of particles moving in random direction
			// at the same speed
			// Time to add ribbon effect
			for(var n = 0; n < particles.length; n++){
				var p2 = particles[n];
				// calculating distance of particle with all other particles
				var yd = p2.location.y - p.location.y;
				var xd = p2.location.x - p.location.x;
				var distance = Math.sqrt(xd*xd + yd*yd);
				// draw a line between both particles if they are in 200px range
				if(distance < 200){
					ctx.beginPath();
					ctx.lineWidth = 1;
					ctx.moveTo(p.location.x, p.location.y);
					ctx.lineTo(p2.location.x, p2.location.y);
					ctx.strokeStyle = p.rgba;
					ctx.stroke();
					//The ribbons appear now.
				}
			}
			// We are using simple vectors here
			// New x = old x + speed * cos(angle)
			p.location.x = p.location.x + p.speed*Math.cos(p.angle*Math.PI/180);
			// New y = old y + speed * sin(angle)
			p.location.y = p.location.y + p.speed*Math.sin(p.angle*Math.PI/180);
			// You can read about vectors here:
			// http://physics.about.com/od/mathematics/a/VectorMath.htm
			if(p.location.x < 0) p.location.x = W;
			if(p.location.x > W) p.location.x = 0;
			if(p.location.y < 0) p.location.y = H;
			if(p.location.y > H) p.location.y = 0;
		}
	}
	setInterval(draw, 30);
}

//  Function for create 2 dates in human-readable format (with leading zero)
//
function PrettyDates(){
	var currDate = new Date();
	var year = currDate.getFullYear();
	var month = currDate.getMonth() + 1;
	var startmonth = 1;
	if (month > 3){
		startmonth = month -2;
	}
	if (startmonth <=9){
		startmonth = '0'+startmonth;
	}
	if (month <= 9) {
		month = '0'+month;
	}
	var day= currDate.getDate();
	if (day <= 9) {
		day = '0'+day;
	}
	var startdate = year +'-'+ startmonth +'-01';
	var enddate = year +'-'+ month +'-'+ day;
	return [startdate, enddate];
}
//
//  Function set min-height of window (required for this theme)
//
function SetMinBlockHeight(elem){
	elem.css('min-height', window.innerHeight - 49)
}


//  Helper for open ModalBox with requested header, content and bottom
//
//
function OpenModalBox(header, inner, bottom){
	var modalbox = $('#modalbox');
	modalbox.find('.modal-header-name span').html(header);
	modalbox.find('.devoops-modal-inner').html(inner);
	modalbox.find('.devoops-modal-bottom').html(bottom);
	modalbox.fadeIn('fast');
	$('body').addClass("body-expanded");
}
//
//  Close modalbox
//
//
function CloseModalBox(){
	var modalbox = $('#modalbox');
	modalbox.fadeOut('fast', function(){
		modalbox.find('.modal-header-name span').children().remove();
		modalbox.find('.devoops-modal-inner').children().remove();
		modalbox.find('.devoops-modal-bottom').children().remove();
		$('body').removeClass("body-expanded");
	});
}
//
//  Beauty tables plugin (navigation in tables with inputs in cell)
//  Created by DevOOPS.
//
(function( $ ){
	$.fn.beautyTables = function() {
		var table = this;
		var string_fill = false;
		this.on('keydown', function(event) {
		var target = event.target;
		var tr = $(target).closest("tr");
		var col = $(target).closest("td");
		if (target.tagName.toUpperCase() == 'INPUT'){
			if (event.shiftKey === true){
				switch(event.keyCode) {
					case 37: // left arrow
						col.prev().children("input[type=text]").focus();
						break;
					case 39: // right arrow
						col.next().children("input[type=text]").focus();
						break;
					case 40: // down arrow
						if (string_fill==false){
							tr.next().find('td:eq('+col.index()+') input[type=text]').focus();
						}
						break;
					case 38: // up arrow
						if (string_fill==false){
							tr.prev().find('td:eq('+col.index()+') input[type=text]').focus();
						}
						break;
				}
			}
			if (event.ctrlKey === true){
				switch(event.keyCode) {
					case 37: // left arrow
						tr.find('td:eq(1)').find("input[type=text]").focus();
						break;
					case 39: // right arrow
						tr.find('td:last-child').find("input[type=text]").focus();
						break;
				case 40: // down arrow
					if (string_fill==false){
						table.find('tr:last-child td:eq('+col.index()+') input[type=text]').focus();
					}
					break;
				case 38: // up arrow
					if (string_fill==false){
						table.find('tr:eq(1) td:eq('+col.index()+') input[type=text]').focus();
					}
						break;
				}
			}
			if (event.keyCode == 13 || event.keyCode == 9 ) {
				event.preventDefault();
				col.next().find("input[type=text]").focus();
			}
			if (string_fill==false){
				if (event.keyCode == 34) {
					event.preventDefault();
					table.find('tr:last-child td:last-child').find("input[type=text]").focus();}
				if (event.keyCode == 33) {
					event.preventDefault();
					table.find('tr:eq(1) td:eq(1)').find("input[type=text]").focus();}
			}
		}
		});
		table.find("input[type=text]").each(function(){
			$(this).on('blur', function(event){
			var target = event.target;
			var col = $(target).parents("td");
			if(table.find("input[name=string-fill]").prop("checked")==true) {
				col.nextAll().find("input[type=text]").each(function() {
					$(this).val($(target).val());
				});
			}
		});
	})
};
})( jQuery );
//
// Beauty Hover Plugin (backlight row and col when cell in mouseover)
//
//
(function( $ ){
	$.fn.beautyHover = function() {
		var table = this;
		table.on('mouseover','td', function() {
			var idx = $(this).index();
			var rows = $(this).closest('table').find('tr');
			rows.each(function(){
				$(this).find('td:eq('+idx+')').addClass('beauty-hover');
			});
		})
		.on('mouseleave','td', function(e) {
			var idx = $(this).index();
			var rows = $(this).closest('table').find('tr');
			rows.each(function(){
				$(this).find('td:eq('+idx+')').removeClass('beauty-hover');
			});
		});
	};
})( jQuery );
//
//  Function convert values of inputs in table to JSON data
//
//
function Table2Json(table) {
	var result = {};
	table.find("tr").each(function () {
		var oneRow = [];
		var varname = $(this).index();
		$("td", this).each(function (index) { if (index != 0) {oneRow.push($("input", this).val());}});
		result[varname] = oneRow;
	});
	var result_json = JSON.stringify(result);
	OpenModalBox('Table to JSON values', result_json);
}


/*-------------------------------------------
	Function for Form Layout page (form layouts.html)
---------------------------------------------*/
//
// Example form validator function
//
//function DemoFormValidator(){
//	$('#defaultForm').bootstrapValidator({
//		message: 'This value is not valid',
//		fields: {
//			username: {
//				message: 'The username is not valid',
//				validators: {
//					notEmpty: {
//						message: 'The username is required and can\'t be empty'
//					},
//					stringLength: {
//						min: 6,
//						max: 30,
//						message: 'The username must be more than 6 and less than 30 characters long'
//					},
//					regexp: {
//						regexp: /^[a-zA-Z0-9_\.]+$/,
//						message: 'The username can only consist of alphabetical, number, dot and underscore'
//					}
//				}
//			},
//			country: {
//				validators: {
//					notEmpty: {
//						message: 'The country is required and can\'t be empty'
//					}
//				}
//			},
//			acceptTerms: {
//				validators: {
//					notEmpty: {
//						message: 'You have to accept the terms and policies'
//					}
//				}
//			},
//			email: {
//				validators: {
//					notEmpty: {
//						message: 'The email address is required and can\'t be empty'
//					},
//					emailAddress: {
//						message: 'The input is not a valid email address'
//					}
//				}
//			},
//			website: {
//				validators: {
//					uri: {
//						message: 'The input is not a valid URL'
//					}
//				}
//			},
//			phoneNumber: {
//				validators: {
//					digits: {
//						message: 'The value can contain only digits'
//					}
//				}
//			},
//			color: {
//				validators: {
//					hexColor: {
//						message: 'The input is not a valid hex color'
//					}
//				}
//			},
//			zipCode: {
//				validators: {
//					usZipCode: {
//						message: 'The input is not a valid US zip code'
//					}
//				}
//			},
//			password: {
//				validators: {
//					notEmpty: {
//						message: 'The password is required and can\'t be empty'
//					},
//					identical: {
//						field: 'confirmPassword',
//						message: 'The password and its confirm are not the same'
//					}
//				}
//			},
//			confirmPassword: {
//				validators: {
//					notEmpty: {
//						message: 'The confirm password is required and can\'t be empty'
//					},
//					identical: {
//						field: 'password',
//						message: 'The password and its confirm are not the same'
//					}
//				}
//			},
//			ages: {
//				validators: {
//					lessThan: {
//						value: 100,
//						inclusive: true,
//						message: 'The ages has to be less than 100'
//					},
//					greaterThan: {
//						value: 10,
//						inclusive: false,
//						message: 'The ages has to be greater than or equals to 10'
//					}
//				}
//			}
//		}
//	});
//}
////
// Function for Dynamically Change input size on Form Layout page
//
function FormLayoutExampleInputLength(selector){
	var steps = [
		"col-sm-1",
		"col-sm-2",
		"col-sm-3",
		"col-sm-4",
		"col-sm-5",
		"col-sm-6",
		"col-sm-7",
		"col-sm-8",
		"col-sm-9",
		"col-sm-10",
		"col-sm-11",
		"col-sm-12"
	];
	selector.slider({
	   range: 'min',
		value: 1,
		min: 0,
		max: 11,
		step: 1,
		slide: function(event, ui) {
			if (ui.value < 1) {
				return false;
			}
			var input = $("#form-styles");
			var f = input.parent();
			f.removeClass();
			f.addClass(steps[ui.value]);
			input.attr("placeholder",'.'+steps[ui.value]);
		}
	});
}
/*-------------------------------------------
	Functions for Progressbar page (ui_progressbars.html)
---------------------------------------------*/
//
// Function for Knob clock
//
function RunClock() {
	var second = $(".second");
	var minute = $(".minute");
	var hour = $(".hour");
	var d = new Date();
	var s = d.getSeconds();
	var m = d.getMinutes();
	var h = d.getHours();
	if (h > 11) {h = h-12;}
		$('#knob-clock-value').html(h+':'+m+':'+s);
		second.val(s).trigger("change");
		minute.val(m).trigger("change");
		hour.val(h).trigger("change");
}
//
// Function for create test sliders on Progressbar page
//
function CreateAllSliders(){
	$(".slider-default").slider();
	var slider_range_min_amount = $(".slider-range-min-amount");
	var slider_range_min = $(".slider-range-min");
	var slider_range_max = $(".slider-range-max");
	var slider_range_max_amount = $(".slider-range-max-amount");
	var slider_range = $(".slider-range");
	var slider_range_amount = $(".slider-range-amount");
	slider_range_min.slider({
		range: "min",
		value: 37,
		min: 1,
		max: 700,
		slide: function( event, ui ) {
			slider_range_min_amount.val( "$" + ui.value );
		}
	});
	slider_range_min_amount.val("$" + slider_range_min.slider( "value" ));
	slider_range_max.slider({
		range: "max",
		min: 1,
		max: 100,
		value: 2,
		slide: function( event, ui ) {
			slider_range_max_amount.val( ui.value );
		}
	});
	slider_range_max_amount.val(slider_range_max.slider( "value" ));
	slider_range.slider({
		range: true,
		min: 0,
		max: 500,
		values: [ 75, 300 ],
		slide: function( event, ui ) {
			slider_range_amount.val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
		}
	});
	slider_range_amount.val( "$" + slider_range.slider( "values", 0 ) +
	  " - $" + slider_range.slider( "values", 1 ) );
	$( "#equalizer > div.progress > div" ).each(function() {
		// read initial values from markup and remove that
		var value = parseInt( $( this ).text(), 10 );
		$( this ).empty().slider({
			value: value,
			range: "min",
			animate: true,
			orientation: "vertical"
		});
	});
}
/*-------------------------------------------
Function for jQuery-UI page (ui_jquery-ui.html)
---------------------------------------------*/
//
//Function for make all Date-Time pickers on page
//
function AllTimePickers(){
$('#datetime_example').datetimepicker({});
$('#time_example').timepicker({
	hourGrid: 4,
	minuteGrid: 10,
	timeFormat: 'hh:mm tt'
});
$('#date3_example').datepicker({ numberOfMonths: 3, showButtonPanel: true});
$('#date3-1_example').datepicker({ numberOfMonths: 3, showButtonPanel: true});
$('#date_example').datepicker({});
}
/*-------------------------------------------
Function for Calendar page (calendar.html)
---------------------------------------------*/
//
//Example form validator function
//
function DrawCalendar(){
/* initialize the external events
-----------------------------------------------------------------*/
$('#external-events div.external-event').each(function() {
	// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
	var eventObject = {
		title: $.trim($(this).text()) // use the element's text as the event title
	};
	// store the Event Object in the DOM element so we can get to it later
	$(this).data('eventObject', eventObject);
	// make the event draggable using jQuery UI
	$(this).draggable({
		zIndex: 999,
		revert: true,      // will cause the event to go back to its
		revertDuration: 0  //  original position after the drag
	});
});
/* initialize the calendar
-----------------------------------------------------------------*/
var calendar = $('#calendar').fullCalendar({
	header: {
		left: 'prev,next today',
		center: 'title',
		right: 'month,agendaWeek,agendaDay'
	},
	selectable: true,
	selectHelper: true,
	select: function(start, end, allDay) {
		var form = $('<form id="event_form">'+
			'<div class="form-group has-success has-feedback">'+
			'<label">Event name</label>'+
			'<div>'+
			'<input type="text" id="newevent_name" class="form-control" placeholder="Name of event">'+
			'</div>'+
			'<label>Description</label>'+
			'<div>'+
			'<textarea rows="3" id="newevent_desc" class="form-control" placeholder="Description"></textarea>'+
			'</div>'+
			'</div>'+
			'</form>');
		var buttons = $('<button id="event_cancel" type="cancel" class="btn btn-default btn-label-left">'+
						'<span><i class="fa fa-clock-o txt-danger"></i></span>'+
						'Cancel'+
						'</button>'+
						'<button type="submit" id="event_submit" class="btn btn-primary btn-label-left pull-right">'+
						'<span><i class="fa fa-clock-o"></i></span>'+
						'Add'+
						'</button>');
		OpenModalBox('Add event', form, buttons);
		$('#event_cancel').on('click', function(){
			CloseModalBox();
		});
		$('#event_submit').on('click', function(){
			var new_event_name = $('#newevent_name').val();
			if (new_event_name != ''){
				calendar.fullCalendar('renderEvent',
					{
						title: new_event_name,
						description: $('#newevent_desc').val(),
						start: start,
						end: end,
						allDay: allDay
					},
					true // make the event "stick"
				);
			}
			CloseModalBox();
		});
		calendar.fullCalendar('unselect');
	},
	editable: true,
	droppable: true, // this allows things to be dropped onto the calendar !!!
	drop: function(date, allDay) { // this function is called when something is dropped
		// retrieve the dropped element's stored Event Object
		var originalEventObject = $(this).data('eventObject');
		// we need to copy it, so that multiple events don't have a reference to the same object
		var copiedEventObject = $.extend({}, originalEventObject);
		// assign it the date that was reported
		copiedEventObject.start = date;
		copiedEventObject.allDay = allDay;
		// render the event on the calendar
		// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
		$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
		// is the "remove after drop" checkbox checked?
		if ($('#drop-remove').is(':checked')) {
			// if so, remove the element from the "Draggable Events" list
			$(this).remove();
		}
	},
	eventRender: function (event, element, icon) {
		if (event.description != "") {
			element.attr('title', event.description);
		}
	},
	eventClick: function(calEvent, jsEvent, view) {
		var form = $('<form id="event_form">'+
			'<div class="form-group has-success has-feedback">'+
			'<label">Event name</label>'+
			'<div>'+
			'<input type="text" id="newevent_name" value="'+ calEvent.title +'" class="form-control" placeholder="Name of event">'+
			'</div>'+
			'<label>Description</label>'+
			'<div>'+
			'<textarea rows="3" id="newevent_desc" class="form-control" placeholder="Description">'+ calEvent.description +'</textarea>'+
			'</div>'+
			'</div>'+
			'</form>');
		var buttons = $('<button id="event_cancel" type="cancel" class="btn btn-default btn-label-left">'+
						'<span><i class="fa fa-clock-o txt-danger"></i></span>'+
						'Cancel'+
						'</button>'+
						'<button id="event_delete" type="cancel" class="btn btn-danger btn-label-left">'+
						'<span><i class="fa fa-clock-o txt-danger"></i></span>'+
						'Delete'+
						'</button>'+
						'<button type="submit" id="event_change" class="btn btn-primary btn-label-left pull-right">'+
						'<span><i class="fa fa-clock-o"></i></span>'+
						'Save changes'+
						'</button>');
		OpenModalBox('Change event', form, buttons);
		$('#event_cancel').on('click', function(){
			CloseModalBox();
		});
		$('#event_delete').on('click', function(){
			calendar.fullCalendar('removeEvents' , function(ev){
				return (ev._id == calEvent._id);
			});
			CloseModalBox();
		});
		$('#event_change').on('click', function(){
			calEvent.title = $('#newevent_name').val();
			calEvent.description = $('#newevent_desc').val();
			calendar.fullCalendar('updateEvent', calEvent);
			CloseModalBox()
		});
	}
	});
	$('#new-event-add').on('click', function(event){
		event.preventDefault();
		var event_name = $('#new-event-title').val();
		var event_description = $('#new-event-desc').val();
		if (event_name != ''){
		var event_template = $('<div class="external-event" data-description="'+event_description+'">'+event_name+'</div>');
		$('#events-templates-header').after(event_template);
		var eventObject = {
			title: event_name,
			description: event_description
		};
		// store the Event Object in the DOM element so we can get to it later
		event_template.data('eventObject', eventObject);
		event_template.draggable({
			zIndex: 999,
			revert: true,
			revertDuration: 0
		});
		}
	});
}
//
//Load scripts and draw Calendar
//
function DrawFullCalendar(){
LoadCalendarScript(DrawCalendar);
}
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//
//      MAIN DOCUMENT READY SCRIPT OF DEVOOPS THEME
//
//      In this script main logic of theme
//
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
$(document).ready(function () {
	$('body').on('click', '.show-sidebar', function (e) {
		e.preventDefault();
		$('div#main').toggleClass('sidebar-show');
		setTimeout(MessagesMenuWidth, 250);
	});
	var ajax_url = location.hash.replace(/^#/, '');
	if (ajax_url.length < 1) {
		ajax_url = '/Home/login';//'index.jsp';
	}
	//LoadAjaxContent(ajax_url);
	var item = $('.main-menu li a[href$="' + ajax_url + '"]');
	item.addClass('active-parent active');
	$('.dropdown:has(li:has(a.active)) > a').addClass('active-parent active');
	$('.dropdown:has(li:has(a.active)) > ul').css("display", "block");
	$('.main-menu').on('click', 'a', function (e) {
		var parents = $(this).parents('li');
		var li = $(this).closest('li.dropdown');
		var another_items = $('.main-menu li').not(parents);
		another_items.find('a').removeClass('active');
		another_items.find('a').removeClass('active-parent');
		if ($(this).hasClass('dropdown-toggle') || $(this).closest('li').find('ul').length == 0) {
			$(this).addClass('active-parent');
			var current = $(this).next();
			if (current.is(':visible')) {
				li.find("ul.dropdown-menu").slideUp('fast');
				li.find("ul.dropdown-menu a").removeClass('active')
			}
			else {
				another_items.find("ul.dropdown-menu").slideUp('fast');
				current.slideDown('fast');
			}
		}
		else {
			if (li.find('a.dropdown-toggle').hasClass('active-parent')) {
				var pre = $(this).closest('ul.dropdown-menu');
				pre.find("li.dropdown").not($(this).closest('li')).find('ul.dropdown-menu').slideUp('fast');
			}
		}
		if ($(this).hasClass('active') == false) {
			$(this).parents("ul.dropdown-menu").find('a').removeClass('active');
			$(this).addClass('active')
		}
		if ($(this).hasClass('ajax-link')) {
			e.preventDefault();
			if ($(this).hasClass('add-full')) {
				$('#content').addClass('full-content');
			}
			else {
				$('#content').removeClass('full-content');
			}
			var url = $(this).attr('href');
			window.location.hash = url;
			LoadAjaxContent(url);
		}
		if ($(this).attr('href') == '#') {
			e.preventDefault();
		}
	});
	var height = window.innerHeight - 49;
	$('#main').css('min-height', height)
		.on('click', '.expand-link', function (e) {
			var body = $('body');
			e.preventDefault();
			var box = $(this).closest('div.box');
			var button = $(this).find('i');
			button.toggleClass('fa-expand').toggleClass('fa-compress');
			box.toggleClass('expanded');
			body.toggleClass('body-expanded');
			var timeout = 0;
			if (body.hasClass('body-expanded')) {
				timeout = 100;
			}
			setTimeout(function () {
				box.toggleClass('expanded-padding');
			}, timeout);
			setTimeout(function () {
				box.resize();
				box.find('[id^=map-]').resize();
			}, timeout + 50);
		})
		.on('click', '.collapse-link', function (e) {
			e.preventDefault();
			var box = $(this).closest('div.box');
			var button = $(this).find('i');
			var content = box.find('div.box-content');
			content.slideToggle('fast');
			button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
			setTimeout(function () {
				box.resize();
				box.find('[id^=map-]').resize();
			}, 50);
		})
		.on('click', '.close-link', function (e) {
			e.preventDefault();
			var content = $(this).closest('div.box');
			content.remove();
		});
	
	$('body').on('click', 'a.close-link', function(e){
		e.preventDefault();
		CloseModalBox();
	});
	$('#top-panel').on('click','a', function(e){
		if ($(this).hasClass('ajax-link')) {
			e.preventDefault();
			if ($(this).hasClass('add-full')) {
				$('#content').addClass('full-content');
			}
			else {
				$('#content').removeClass('full-content');
			}
			var url = $(this).attr('href');
			window.location.hash = url;
			LoadAjaxContent(url);
		}
	});
	$('#search').on('keydown', function(e){
		if (e.keyCode == 13){
			e.preventDefault();
			$('#content').removeClass('full-content');
			ajax_url = '/hiapt/views/ajax/page_search.html';
			window.location.hash = ajax_url;
			LoadAjaxContent(ajax_url);
		}
	});
	
});

// 달력=======================================================================
//Draw all test Chartist Charts
function DrawChartistCharts(){
	DrawChartistChart1();
	DrawChartistChart2();
	DrawChartistChart3();
	DrawChartistChart4();
	DrawChartistChart5();
}
function DrawChartistChart1(){
	Chartist.Line('#chartist-1', {
		labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October',
			'November', 'December'],
		series: [
			[12, 9, 7, 8, 5, 5, 17, 11 , 12, 6, 3, 9],
			[2, 1, 3.5, 7, 3, 6, 2, 9, 1, 21, 15, 1],
			[1, 3, 4, 5, 6, 1, 15, 3, 9, 11, 18, 14]
		]
	});
}
function DrawChartistChart2(){
	var times = function(n) {
		return Array.apply(null, new Array(n));
	};
	var data = times(52).map(Math.random).reduce(function(data, rnd, index) {
		data.labels.push(index + 1);
		data.series.forEach(function(series) {
			series.push(Math.random() * 100)
		});
		return data;
	}, {
		labels: [],
		series: times(4).map(function() { return new Array() })
	});
	var options = {
		showLine: false,
		axisX: {
			labelInterpolationFnc: function(value, index) {
				return index % 13 === 0 ? 'W' + value : null;
			}
		}
	};
	var responsiveOptions = [
		['screen and (min-width: 640px)', {
			axisX: {
				labelInterpolationFnc: function(value, index) {
					return index % 4 === 0 ? 'W' + value : null;
				}
			}
		}]
	];
	Chartist.Line('#chartist-2', data, options, responsiveOptions);
}
function DrawChartistChart3(){
	Chartist.Line('#chartist-3', {
		labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11],
		series: [
				[1, 2, 3, 1, -2, 0, 1, 0, 3, -1, 1],
				[-2, -1, -2, -1, -2.5, -1, -2, -1, -2, 2, -2],
				[0, 0, 0, 1, 2, 2.5, 2, 1, 4, -3, 1],
				[2.5, 2, 1, 0.5, 1, 0.5, -1, -2.5, -1, 2, 1]
			]
		}, {
			high: 3,
			low: -3,
			showArea: true,
			showLine: false,
			showPoint: false,
			axisX: {
				showLabel: false,
				showGrid: false
			}
		});
}
function DrawChartistChart4(){
	Chartist.Pie('#chartist-4', {
		series: [20, 10, 30, 40]
	}, {
		donut: true,
		donutWidth: 60,
		startAngle: 270,
		total: 200,
		showLabel: false
	});
}
function DrawChartistChart5(){
	var data = {
		labels: ['W1', 'W2', 'W3', 'W4', 'W5', 'W6', 'W7', 'W8', 'W9', 'W10', 'W11', 'W12', 'W13', 'W14', 'W15', 'W16', 'W17', 'W18'],
		series: [
				[1, 2, 4, 8, 6, -2, -1, -4, -6, -2, 3, 6, 1, -4, 2, 7, -1, 3]
			]
	};
	var options = {
		high: 10,
		low: -10,
		axisX: {
			labelInterpolationFnc: function(value, index) {
				return index % 2 === 0 ? value : null;
			}
		}
	};
	Chartist.Bar('#chartist-5', data, options);
}


