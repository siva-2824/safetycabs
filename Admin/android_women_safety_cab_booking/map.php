<?php
 include("dbconnect.php");
session_start();
extract($_POST);
 
 $id=$_REQUEST['id'];
 

 $listeDesPoints='';
// $listeDesPoints.='['.$l1.','.$l2.']';
 $qry="select * from booking_details where id='$id'";
 
 $result = $conn->query($qry);
 
	 
		
	 	while($row = $result->fetch_assoc())
 
	 {
	  $rtt=$row['latitude'];
	  $trr=$row['longitude'];
     if($listeDesPoints!='') $listeDesPoints.=','; 
      $listeDesPoints.='['.$row['latitude'].','.$row['longitude'].']';
	  
	    $rtt1=$row['destination_latitude'];
	  $trr1=$row['destination_longitude'];
     if($listeDesPoints!='') $listeDesPoints.=','; 
      $listeDesPoints.='['.$row['destination_latitude'].','.$row['destination_longitude'].']';
     }
	 
	  
	 
?>
       <html>
        <head>
          <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
          <style type="text/css">
           html { height: 100% }
           body { height: 100%; margin: 0; padding: 0 }
           #map_canvas { height: 100% }
           </style>
           <script type="text/javascript"
           src="http://maps.googleapis.com/maps/api/js?key=AIzaSyB3is760vHXhki9vS_LpiWAig8a33GP3CY&sensor=false">
           </script>
        <script type="text/javascript">
         function initialize() {
            var optionsCarte = {
              center: new google.maps.LatLng(10.00,79.00),
              zoom: 10,
              mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new     google.maps.Map(document.getElementById("map_canvas"),
            optionsCarte);
            var liste_des_points=[<?php echo $listeDesPoints; ?>];
            var i=0,li=liste_des_points.length;
            while(i<li){
            new google.maps.Marker({
                   position: new google.maps.LatLng(liste_des_points[i][0], liste_des_points[i][1]),
                   map: map,
            });
            i++;
            }
          }
        </script>
      </head>
      <body onLoad="initialize()">
        <div id="map_canvas" style="width:100%; height:100%">    </div>
      </body>
      </html>