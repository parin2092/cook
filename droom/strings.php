<?php

$weight = [];
$weight['a']=1;
$weight['b']=2;
$weight['c']=3;
$weight['d']=4;
$weight['e']=5;
$weight['f']=6;
$weight['g']=7;
$weight['h']=8;
$weight['i']=9;
$weight['j']=10;
$weight['k']=11;
$weight['l']=12;
$weight['m']=13;
$weight['n']=14;
$weight['o']=15;
$weight['p']=16;
$weight['q']=17;
$weight['r']=18;
$weight['s']=19;
$weight['t']=20;
$weight['u']=21;
$weight['v']=22;
$weight['w']=23;
$weight['x']=24;
$weight['y']=25;
$weight['z']=26;

function countWeight($str,$k){
	$n = strlen($str);
	global $weight;

	$dp = array_fill(0, $n, array_fill(0, $n, 0));

	for($i = 0 ; $i < $n ; $i++){
		$dp[$i][$i] = $weight[$str[$i]];
	}
	for($gap= 1; $gap < $n ; $gap++){
		$l = 0;
		$h = $gap;
		while($h < $n){
			if ($l == 0) {
				$dp[$l][$h] = $dp[$l][$h-1] + $weight[$str[$h]];
			}else{
 				$dp[$l][$h] = $dp[$l-1][$h-1] - $weight[$str[$l-1]] + $weight[$str[$h]];
			}

			$l++;
			$h++;
		}
	}
	$count = 0;
	for($i = 0 ; $i < $n;$i++){
		for($j = 0;$j < $n;$j++){
			if ($dp[$i][$j] == $k) {
				$count++;
			}
		}
	}
	print_r($dp);
	return $count;
}

$str = 'parinkataria';
print countWeight($str,5);

fscanf(STDIN, "%d\n", $t);
for($i = 0; $i < $t ; $i++){
	fscanf(STDIN, "%d\n", $k);
	fscanf(STDIN, "%s\n", $str);
	$ans = countWeight($str,$k);
	print $ans."\n";
}
?>
