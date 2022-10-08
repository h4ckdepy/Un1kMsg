import base64
import requests
from Crypto.Cipher import AES
from urllib import parse
import hashlib


##配置SendKey

def send(SENDKEY,TITLE,CONTENT):
    API = 'http://un1kmsg.happysec.cn/index/processmsg/'
    headers = {
        "Content-Type": "application/x-www-form-urlencoded"
    }
    CONTENT = parse.quote(CONTENT)
    myobj = {'title': TITLE, 'content': CONTENT,'sendkey':SENDKEY}
    res = requests.post(API,data = myobj,headers=headers).text
    print(res)

SENDKEY = 'ZX0zaHCWMR0qhQvZerkwXPJ1aabuMkJh4TxGZnRzhKu03FBi'
TITLE = input("Set headers smaller than 32 bits:")
CONTENT = input("Set your transfer content:")
send(SENDKEY,TITLE,CONTENT)

## You can write end-to-end encryption by yourself
# def add_to_16(value):
#     while len(value) % 16 != 0:
#         value += '\0'
#     return str.encode(value)  # 返回bytes
#
# def encrypt_oracle(key,content):
#     text = base64.b64encode(content.encode('utf-8')).decode('ascii')
#     # 初始化加密器
#     aes = AES.new(add_to_16(key),AES.MODE_CBC,key)
#     #先进行aes加密
#     encrypt_aes = aes.encrypt(add_to_16(text))
#     encrypt_aes.decode().replace("\n","").replace("\r","")
#     #用base64转成字符串形式
#     encrypted_text = str(base64.encode(encrypt_aes), encoding='utf-8')  # 执行加密并转码返回bytes
#     return encrypted_text
# Crypto = input("Enable end-to-end encryption?")
# if Crypto == 'y':
#     secret = input("Input Your Secret:")
#     hl = hashlib.md5()
#     hl.update(secret.encode(encoding='utf-8'))
#     secret = hl.hexdigest()[:16]
#     encrypted_text = encrypt_oracle(secret, CONTENT)
#     print(encrypted_text)
#     encrypted_text = parse.quote(parse.quote(encrypted_text))
#     API = API.format(TITLE, encrypted_text, SENDKEY)
#     print("[+] Your Secret Content :"+encrypted_text)
#     print(API+"&crypto=1")
#     res = AES_Encrypt("1234561234561111","fuckyou")
#     print(res)
# else:
#     CONTENT = parse.quote(parse.quote(CONTENT))
#     API = API.format(TITLE,CONTENT,SENDKEY)
#     print(API)



