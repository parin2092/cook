<?php
	class Test{
		public $pub = array('key'=>'value');
		private $pri;
		protected $pro;
		public function __construct(){
			// print "weocome";
		}
		public function __destruct(){
			// print "Bye";
		}
		public function test(){
			print "no args";
		}
		public function __set($name,$value){
			print "setting {$name} to {$value}".PHP_EOL;
		}
	}
	$t = new Test;
	// $t->pub  = "parin";
	// $t->pro  = "parin";
	// $t->pri  = "parin";
	// $t->anotherVariable  = "parin";
	// $t->notDeclared  = "parin";
	var_dump($t);
	// echo($t);
	print_r($t);
	print E_USER_ERROR;
?>