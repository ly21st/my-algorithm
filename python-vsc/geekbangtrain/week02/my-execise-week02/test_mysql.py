import pymysql.cursors

# Connect to the database
# connection = pymysql.connect(host='10.8.4.121',
#                              user='root',
#                              password='123456',
#                              db='db',
#                              charset='utf8mb4',
#                              cursorclass=pymysql.cursors.DictCursor)

connection = pymysql.connect(host='10.8.4.121',
                             user='root',
                             password='123456',
                             db='db',
                             charset='utf8mb4')

try:
    with connection.cursor() as cursor:
        # Create a new record
        sql = "INSERT INTO `users` (`email`, `password`) VALUES (%s, %s)"
        cursor.execute(sql, ('webmaster@python.org', 'very-secret'))
        # 注意，sql语句里面的字符串%s不用写成"%s"的形式，否则不会得到期望的结果
        # sql = 'INSERT INTO `users` (`email`, `password`) VALUES ("%s", "%s")'
        # cursor.execute(sql, ('webmaster@python.org', 'very-secret'))

    # connection is not autocommit by default. So you must commit to save
    # your changes.
    connection.commit()

    with connection.cursor() as cursor:
        # Read a single record
        sql = "SELECT `id`, `password` FROM `users` WHERE `email`=%s"
        cursor.execute(sql, ('webmaster@python.org',))
        result = cursor.fetchone()
        print(result)
finally:
    connection.close()