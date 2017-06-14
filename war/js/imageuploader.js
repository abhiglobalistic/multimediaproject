
$(function () {
    $(":file").change(function () {
        if (this.files && this.files[0]) {
           var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
            
        }
    });
});

/*var files;
$("input[type='file']").on("change",function(e) {
        files = e.target.files;*/

        
function imageIsLoaded(e) {
    var data = new FormData();
    
    data.image = e.target.result;
    
    
    $.ajax({
        url: "http://localhost:8888/upload",
        type : "POST",
        dataType: "application/json",
        contentType: "json",
        data: JSON.stringify(data),
        cache: false,
        processData : false,
        contentType: false,
        success: function(data, textStatus, jqXHR){
        	console.log('image Blob', textStatus);
        },
        error: function(jqXHR, textStatus, errorThrown){
        	console.log('Error in image Blob', errorThrown);
        }
    });
}
//});




/*function imageIsLoaded(e) {
    //$('#myImg').attr('src', e.target.result);
	
	var data = new FormData();
//    $.each(this.files[0], function(key, value){
//        data.append(key, value);
//    });
    	
	data.append("image",e.target.result);
	var url = "http://localhost:8888/upload";
     
  
          $.ajax({
                url: url,
                method: 'POST',
                data:data,
                cache: false,
                dataType: 'JSON',
                context:this
           }).fail(function (JQXhr, textStatus, errorMessage) {
                console.log('Error in image Blob', errorMessage);
            }).done(function (response) {
                console.log('Image Blob ', response);

            });*/
            
            
	
//    var request=new XMLHttpRequest();
//    var stringParameter = e.target.result ;
//    request.open("POST", "http://localhost:8888/upload", true);
//    request("image",stringParameter);
//    request.send();
//};