$(document).ready(function(){
//alert("objPage.js");
$('#buttonSubmit').on('click', function(event) {
//    alert("objPage.js");
    var objName = "Primal Obj Name";
//     alert(objName);
    objName = $('#objName').val();
    // alert(objName);
    functionResultData(objName);
});

function functionResultData(objName){
//     alert("Begin functionResultData");
   $.ajax({
        url: '${pageContext.request.contextPath}/obj-controller',
        method: 'POST',
        data: {objName:objName},
//        dataType : 'json',
        success: function(requestData){
            alert("Success of functionResultData");
            $('#resultData').text(requestData);
        },
        error: function(error){
            console.log(error);
        }
    });}
});
//alert("objPage.js");

