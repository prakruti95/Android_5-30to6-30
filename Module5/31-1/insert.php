<?php
  
   include('connect.php');
    
   $name = $_REQUEST["name"];
   $surname = $_REQUEST["surname"];
   
   if($name=="" && $surname=="")
   {
     echo '0';
   } 
   else
   {
     $sql = "insert into info (name,surname) values ('$name','$surname')";
     mysqli_query($con,$sql);
   }
 

?>