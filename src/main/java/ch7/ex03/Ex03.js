b = new java.math.BigInteger('1234567890987654321')
print(b)
print(java.lang.String.format('%d', b))
result = b < 1.79 * Math.pow(2, 53)
print(result)
c = b.mod(java.math.BigInteger.TEN)
print(c)
