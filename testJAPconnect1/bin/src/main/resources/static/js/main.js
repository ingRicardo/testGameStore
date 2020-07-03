/**
 * 
 */

$(document).ready(function () {

    $("#add-form").submit(function (event) {

	
        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["name"] = $("#name").val();
	 
	search["cost"] = $("#cost").val();
	search["category"] = $("#category").val();
	
    $("#addgame").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/addGame",
        data: JSON.stringify(search),
        dataType: 'json',
    //    cache: false,
        timeout: 100000,
        success: function (data) {

        //    var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
        //        + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
       //     $('#feedback').html(json);

            console.log("SUCCESS : ", data);
			alert("SUCCESS : "+ data);
            $("#addgame").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
          // $('#feedback').html(json);

            console.log("ERROR : ", e);
 			alert("ERROR : "+ e);
            $("#addgame").prop("disabled", false);

        },
		done : function(e) {
			alert("DONE : "+ e);
			console.log("DONE");
		}
    });

}