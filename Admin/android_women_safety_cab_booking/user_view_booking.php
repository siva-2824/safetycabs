 <?php
include("dbconnect.php");
extract($_POST);
$user=$_REQUEST['user'];
echo $qry=("select * from booking_details where user='$user' and status='1' order by id");
$rt=$qry;
$result = array();
$result1 = $conn->query($qry);
 
	 
		
	 	while($res = $result1->fetch_assoc())
		  {
array_push($result,array("id"=>$res['id'],"user"=>$res['user'],"latitude"=>$res['latitude'],"longitude"=>$res['longitude'],"source"=>$res['source'],"destination"=>$res['destination'],"driver_name"=>$res['driver_name'],"driver_l1"=>$res['driver_l1'],"driver_l2"=>$res['driver_l2'],"status"=>$res['status'],"amount"=>$res['amount']));
}
echo json_encode(array("result"=>$result));
 
?>
 
 