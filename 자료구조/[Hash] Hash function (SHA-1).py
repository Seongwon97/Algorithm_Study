import hashlib
# Hashlib에는 SHA알고리즘 등이 들어있다.

data = 'test'.encode() 
# encoding을 한다는 것은 unicode, aschii코드로 된 'test'를 byte로 바꿔주는 것
# encode를 하는 대신 b'test'를 해줘도 된다. b를 text앞에 붙여주는 것은 byte로 변경해준다는 뜻.
hash_object = hashlib.sha1()
hash_object.update(data)
hex_dig = hash_object.hexdigest() # Hashobject를 16진수로 추출
print (hex_dig)
