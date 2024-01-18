print("Product A:$20")
print("Product B:$40")
print("Product C:$50")
print("----------------------------------------------")

qtyA = int(input("Enter the quantity of Product A:"))
if qtyA>0:
    giftA = input("Should product be gift wrapped? yes/no:")
else:
    giftA = "no"

qtyB = int(input("Enter the quantity of Product B:"))
if qtyB>0:
    giftB = input("Should product be gift wrapped? yes/no:")
else:
    giftB = "no"

qtyC = int(input("Enter the quantity of Product C:"))
if qtyC>0:
    giftC = input("Should product be gift wrapped? yes/no:")
else:
    giftC = "no"

subTotal = qtyA*20 + qtyB*40 +qtyC*50


discount = 0
discountName = ""

if subTotal>200:
    discount = 10
    discountName = "flat_10_discount"

if qtyA>10 or qtyB>10 or qtyC>10:
    tempDiscount=0
    if(qtyA>10):
        tempDiscount = qtyA*28*0.05
    if(qtyB>10):
        tempDiscount = qtyB*40*0.05
    if(qtyC>10):
        tempDiscount = qtyC*50*0.05

    if tempDiscount>discount:
        discount = tempDiscount
        discountName = "bulk_5_discount"

if qtyA+qtyB+qtyC>20:
    tempDiscount = subTotal*0.1 
    if tempDiscount>discount:
        discount = tempDiscount
        discountName = "bulk_10_discount"       

if qtyA+qtyB+qtyC>30 and (qtyA>15 or qtyB>15 or qtyC>15):
    tempDiscount = 0
    if qtyA>15:
        tempDiscount = (qtyA-15) * 20 * .50
    if qtyB>15:
        tempDiscount = (qtyB-15) * 40 * .50
    if qtyC>15:
        tempDiscount = (qtyC-15) * 50 * .50
    if tempDiscount>discount:
        discount = tempDiscount
        discountName = "tiered_50_discount"

totalQty = qtyA + qtyB + qtyC
shippingFee = (totalQty // 10 + (totalQty % 10 > 0)) * 5

giftWrapFee = 0
if giftA == "yes":
    giftWrapFee += qtyA*1
if giftB == "yes":
    giftWrapFee += qtyB*1
if giftC == "yes":
    giftWrapFee += qtyC*1

total = subTotal - discount + shippingFee + giftWrapFee

print("--------------------------------------------------")
print("Order details:")
print("--------------------------------------------------")
print(f"{'Product Name':<12} {'Quantity':<10} {'Total':<5}")
print(f"{'Product A':<12} {qtyA:<10} ${qtyA*20:<5}")
print(f"{'Product B':<12} {qtyB:<10} ${qtyB*40:<5}")
print(f"{'Product C':<12} {qtyC:<10} ${qtyC*50:<5}")

print("Subtotal: $" + str(subTotal))
print("Discount (" + discountName + "): -$" + str(discount))
print("Shipping fee: $" + str(shippingFee))
print("Gift wrap fee: $" + str(giftWrapFee))
print("Total: $" + str(total))
    