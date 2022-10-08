<?php

function send($title , $content = '' , $sendkey = ''  )
{
    $postdata = http_build_query( array( 'title' => $title, 'content' => $content,'sendkey'=>$sendkey ));
    $options = array(
        'http' => array(
          'method' => 'POST',
          'header' => 'Content-type:application/x-www-form-urlencoded',
          'content' => $postdata,
          'timeout' => 15 * 60 // 超时时间（单位:s）
        ),
        "ssl" => array(
            "verify_peer"=>false,
            "verify_peer_name"=>false,
         )
      );
      $context = stream_context_create($options);
      $result = file_get_contents('https://un1kmsg.happysec.cn/index/processmsg/', false, $context);
      return $result;

}

$sendkey = '';
echo send('un1kmsg','un1kmsg-content',$sendkey);
