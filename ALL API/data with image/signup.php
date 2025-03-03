<?php

		include('connect.php');
		
		$name = $_POST["name"];
		$surname = $_POST["surname"];
		$email = $_POST["email"];
 	    $gender= $_POST["gender"];
        $mobile = $_POST["mobile"];
		$password = $_POST["password"];
		
		
		if($name=="" && $surname=="" && $email==""  && $gender=="" && $mobile=="" && $password=="")
		{
			echo'0';
		}
		else
		{
			$sql = "insert into users8(name,surname,email,gender,mobile,password) values ('$name','$surname','$email','$gender','$mobile','$password')";
			mysqli_query($con,$sql);
			
		}
		


?>