$(document).ready(function(){
//alert("Ready Obj.js");

$('#buttonSubmit').on('click', function() {
    var objName = "Primal Obj Name";
    objName = $('#objName').val();
    clickButton(objName);
});

$('#objName').on('input', function(){
    var objName = $('#objName').val();
    inputObjName(objName);
});

function inputObjName(objName){
    $.ajax({
        url: '${pageContext.request.contextPath}/input-obj-name',
        method: 'POST',
        data: {objName:objName},
        success: function(resultData){
            $('#resultData').text(resultData);
        },
        error: function(error){
            console.log(error);
        }
    });
}

function clickButton(objName){
   $.ajax({
        url: '${pageContext.request.contextPath}/obj-controller',
        method: 'POST',
        data: {objName:objName},
        success: function(resultData){
//            alert("ajax button");
            $('#resultData').text(resultData);
        },
        error: function(error){
            console.log(error);
        }
    });
    }
}
);

