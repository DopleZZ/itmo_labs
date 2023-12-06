import task0
import task1
import task2
import time

start_time = time.time() 
for i in range(100):   
    task0
end_time = time.time()  
execution_time = end_time - start_time      
print(f"стократное время выполнения основной программы: {execution_time} секунд")

start_time = time.time() 
for i in range(100):   
    task1
end_time = time.time()  
execution_time = end_time - start_time      
print(f"стократное время выполнения  программы c библиотеками: {execution_time} секунд")

start_time = time.time() 
for i in range(100):   
    task2
end_time = time.time()  
execution_time = end_time - start_time      
print(f"стократное время выполнения программы с регулряными выражниями: {execution_time} секунд")