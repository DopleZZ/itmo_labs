import re
print(__import__('re').sub(r'\b(\w+)([^\w]+\1)+\b', r'\1', open('task2_test.txt').read(),flags=re.IGNORECASE))
