<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
</head>
<body>

opo

<div id="categories">

</div>

<script>
    window.onload = function(){
        loadCategories();
    };

    function loadCategories() {
        var xhr = new XMLHttpRequest();
        xhr.open("get", "/api/category");
        xhr.setRequestHeader("content-type", "application/json");
        xhr.setRequestHeader("authorization", "Basic bWF4OjEyMw==");

        xhr.send();
        xhr.onreadystatechange = function(){
            if (xhr.readyState == XMLHttpRequest.DONE) {
                var response = JSON.parse(xhr.responseText);
                for (var i = 0; i < response.length; i++){
                    document.querySelector("#categories").innerHTML += response[i].name + "<br>";
                }
            }
        }
    }
</script>
</body>
</html>