import zipfile
zFile = zipfile.ZipFile("magic.zip")
passFile = open('dictionary.txt',encoding="utf-8")

for line in passFile.readlines():
        password = line.strip('\n')
        try:
                zFile.extractall(path="./magic",pwd=password.encode('utf-8'))
                print('Password : ', password)
                exit(0)
        except Exception as e:
                print (e)