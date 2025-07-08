
<?php
include("dbconnect.php");
 
extract($_POST);
  $driver=$_REQUEST['driver'];
  $id=$_REQUEST['id'];

 
$qry=("select * from booking_details where id='$id'");
$rt=$qry;
$result = array();
$result1 = $conn->query($qry);
 
	 
		
	 	while($res = $result1->fetch_assoc())
		  {
		  $driver_name=$res["driver_name"];
		  $aa="select * from driver_details where email='$driver_name'";
		  $result21 = $conn->query($aa);
		  while($res1 = $result21->fetch_assoc())
		  {
		   $driver_name=$res1["name"];
		   $driver_contact=$res1["contact"];
		   $driver_email=$res1["email"];
		   $driver_address=$res1["address"];
		   $driver_license_no=$res1["license_no"];
		   $driver_vehicle_name=$res1["vehicle_name"];
		   $driver_vehicle_no=$res1["vehicle_no"];
		  }

echo $result=$res['id'].'#'.$res['user'].'#'.$res['source'].'#'.$res['destination'].'#'.$res['driver_name'].'#'.$driver_name.'#'.$driver_contact.'#'.$driver_email.'#'.$driver_address.'#'.$driver_license_no.'#'.$driver_vehicle_name.'#'.$driver_vehicle_no.'#'.$res['amount'];
}
//echo json_encode(array("result"=>$result));
?>
 
 