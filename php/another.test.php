<?php
$d1 = date('2012-2-21');
$d2 = date('2014-2-21');
print_r( $d2 - $d1);
$data = file_get_contents("http://img-9gag-ftw.9cache.com/photo/aGVqbvz_700b.jpg");
$fp = fopen('test.jpg', 'w');
fwrite($fp, $data);
?>