/**
 * 
 * 
 * document.querySelector('#show_button').addEventListener('click', function() {
  if (window.webkitNotifications.checkPermission() == 0) { // 0 is PERMISSION_ALLOWED
    // function defined in step 2
    window.webkitNotifications.createNotification(
        'icon.png', 'Notification Title', 'Notification content...');
  } else {
    window.webkitNotifications.requestPermission();
  }
}, false);

PASSO 2

document.querySelector('#show_button').addEventListener('click', function() {
  if (window.webkitNotifications.checkPermission() == 0) { // 0 is PERMISSION_ALLOWED
    // function defined in step 2
    notification_test = window.webkitNotifications.createNotification(
      'icon.png', 'Notification Title', 'Notification content...');
    notification_test.ondisplay = function() { ... do something ... };
    notification_test.onclose = function() { ... do something else ... };
    notification_test.show();
  } else {
    window.webkitNotifications.requestPermission();
  }
}, false);




<html>
<head>
    <title>Realtime Notifications</title>
    <script src="//js.pusher.com/3.1/pusher.min.js" type="text/javascript"></script>
    <script src="//code.jquery.com/jquery-2.1.3.min.js" type="text/javascript"></script>
</head>
<body>

    <div class="notification"></div>

    <script>

        var pusher = new Pusher('YOUR_APP_KEY');

        var notificationsChannel = pusher.subscribe('notifications');

        notificationsChannel.bind('new_notification', function(notification){
            var message = notification.message;
            $('div.notification').text(message);
        });

    </script>

</body>
</html>



 */