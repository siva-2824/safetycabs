<?php
extract($_POST);
include("dbconnect.php");
$event=$_REQUEST['uname'];
$staff=$_REQUEST['pword'];
//$pass=$_REQUEST['pass'];
//$time=$_REQUEST['time'];
$qry=("select * from user_details where email='$event' && password='$staff'");
 
$result = mysqli_query($conn, $qry);
 if (mysqli_num_rows($result)) 
  {
echo "success";
}
else
{
echo "failed";
}
?>
 