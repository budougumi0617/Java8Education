result = 0
if($ENV.AGE != null){
    result = $ENV.AGE
}
if($ARG[0] != null){
    result = $ARG[0]
}else if (result == 0){
    result = readLine('Input your age : ')
}
result++
print('Next year, You will be ...' + result + ' old.')
