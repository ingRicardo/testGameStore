/**
 * 
 */

 
// if(jQuery) alert('jQuery is loaded');



 $("#thetable-test").click(function() {
  //  var $row = $(this).closest("tr");    // Find the row
  //  var $text = $row.find(".nr").text(); // Find the text
console.log("clicked");
alert ("----");    
    // Let's test it out
 //   alert($text);

});




 $(".use-test").click(function() {
  //  var $row = $(this).closest("tr");    // Find the row
  //  var $text = $row.find(".nr").text(); // Find the text
console.log("clicked");
alert ("----");    
    // Let's test it out
 //   alert($text);

});

$('#thetable-test').on('click', '.use-test', function()
{
	console.log("clicked");
    alert($(this).closest('tr').find('.nr').val());

});

$('.use-test').on('click', function () {
	
	
	console.log("clicked");
	alert("llllll");
	});