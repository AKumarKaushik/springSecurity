<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
    <title>Demo</title>
    <meta content="" name="description"/>
    <meta content="width=device-width" name="viewport"/>
    <base href="/"/>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="/webjars/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<h1>Demo</h1>

<!--For js cookies-->
<script src="/webjars/js-cookie/js.cookie.js" type="text/javascript"></script>

<script type="text/javascript">
    $.get("/user", function (data) {
        $("#user").html(data.userAuthentication.details.name);
        $(".unauthenticated").hide();
        $(".authenticated").show()
    });

    // logout function
    var logout = function () {
        $.post("/logout", function () {
            $("#user").html('');
            $(".unauthenticated").show();
            $(".authenticated").hide();
        });
        return true;
    };


    $.ajaxSetup({
        beforeSend: function (xhr, settings) {
            if (settings.type == 'POST' || settings.type == 'PUT'
                || settings.type == 'DELETE') {
                if (!(/^http:.*/.test(settings.url) || /^https:.*/
                    .test(settings.url))) {
// Only send the token to relative URLs i.e. locally.
                    xhr.setRequestHeader("X-XSRF-TOKEN",
                        Cookies.get('XSRF-TOKEN'));
                }
            }
        }
    });

</script>

<div class="container authenticated" style="display:none">
    Logged in as: <span id="user"></span>
    <div>
        <button class="btn btn-primary" onClick="logout()">Logout</button>
    </div>
</div>

<h1>Login</h1>
<div class="container unauthenticated">
    <div>
        With Facebook: <a href="/login/facebook">click here</a>
    </div>

    <div>
        With Github: <a href="/login/github">click here</a>
    </div>

    <div>
        With Google: <a href="/google/login">click here</a>
    </div>
</div>


<div class="container"></div>
</body>
</html>