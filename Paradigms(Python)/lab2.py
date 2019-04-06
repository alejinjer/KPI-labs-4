import re
email_address = "Please contact us at: support@datacamp.com, xyz@datacamp.com"
addresses = re.findall(r'[\w\.-_]+@[\w.]+', email_address)
for address in addresses: 
    print(address)