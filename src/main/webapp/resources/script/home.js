$(document).ready(function(){
    // alert("home.js");

    $('#searchInput').on('input', function(){
        var searchValue = $(this).val();
        var actionUrl = "${pageContext.request.contextPath}/homeSearchBox";
        loadObjectList(searchValue, actionUrl);
    });

    // $('#searchButton').on('click', function(){
    //     // alert("search button clicked");
    //     var searchValue = $('#searchInput').val();
    //     // alert("Searching "+searchValue);
    //     var actionUrl = "${pageContext.request.contextPath}/homeSearchBox";
    //     loadObjectList(searchValue, actionUrl);
    // });

    function loadObjectList(searchValue, actionUrl){
        // alert("To loadObjectList");
        $.ajax({
            url: actionUrl,
            method: 'POST',
            data: {searchValue: searchValue},
            success: function(objList){
                var tbody = $('#objTable tbody');
                tbody.empty();
                
                // alert(objList.length);
                if(objList.length===0){
                    var row = '<tr><td colspan="3">List is empty</td></tr>';
                }else{
                    // alert("list size is: "+objList.length);
                    for (var i=0; i<objList.length;i++){
                        var obj = objList[i];
                        var row = '<tr><td>'+obj.objId+'</td><td>'+obj.objName+'</td><td>'+obj.objData+'</td></tr>';
                        tbody.append(row);
                    }
                }
            },
            error: function(error){
                alert(error);
                console.log(error);
            }
        });
    }
});
