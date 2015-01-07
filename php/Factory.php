<?php
abstract class Toy{
	public $name ;
	public $price;

	public function prepare(){
		print "Preparing {$this->name}".PHP_EOL;
	}

	public function package(){
		print "Packing {$this->name}".PHP_EOL;
	}

	public function label(){
		print "Labeling {$this->name} to price {$this->price}".PHP_EOL;
	}
}
class Car extends Toy{
	public $name = "Car";
	public $price = 20;
}

class Heli extends Toy{
	public $name = "heli";
	public $price = 40;
}
/////////////////////////
// print_r((new Car)); //
// print_r(new Heli);  //
/////////////////////////

abstract class ToyFactory{
	abstract function createToy($toyName);
	public function produceToy($toyName){
		$toy = null;
		$toy = $this->createToy($toyName);
		$toy->prepare();
		$toy->package();
		$toy->label();
		return $toy;
	}
}
class NyToyFactory extends ToyFactory{
	public function createToy($toyName){
		switch($toyName){
			case 'car':return new Car;
			case 'heli':return new Heli;
			default : return null;
		}
	}
}
$nyf = new NyToyFactory;
$nyf->produceToy('car');
try{
	$nyf->produceToy('heli');
}finally{
	echo "hello";
}
?>