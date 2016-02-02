public class PurchaseOrderController {
 	public List<Product2> productList{get;set;}
    public List<PurchaseOrderLineItem__c> productsToPurchase{get;set;}
    public Set<ID> productsToPurchaseItem{get;set;}
    public String productId{get;set;}
    public Integer quantity{get;set;}
    public Product2 selectedProduct{get;set;}
    public PurchaseOrder__c order{get;set;}
 	public List<PurchaseOrder__c> ListOfOrder{get;set;}    
    public boolean purchaseOrderLineItemsdisplayPopUp {get; set;}     
    public boolean purchaseOrderdisplayPopUp {get; set;}  
    public boolean informationDisplayPopUp {get; set;} 
    public boolean OrderDisplayPopUp{get;set;}
    
    
    public PurchaseOrderController(ApexPages.StandardController controller){
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
        OrderDisplayPopUp=false;
        getProductList();
        
        productsToPurchase = new List<PurchaseOrderLineItem__c>();
        ListOfOrder=new List<PurchaseOrder__c>();
        productsToPurchaseItem = new Set<ID>();
        
    }
    
    
    public Void getProductList(){
        string Query = 'SELECT id,name,price__c FROM Product2';
        productList = Database.query(Query);
    }
    
    public Void addToCart(){
       
        ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c];
    
        List<PurchaseOrder__c> orderList=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c from PurchaseOrder__c where Order_Status__c=false];
        if(orderList.size()>0){
            order=orderList.get(0);     
        }else{
            order=new PurchaseOrder__c(Name='OrderNew');
            insert order;
        }
        
        
        productsToPurchase= [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where OrderId__c=:order.Id];
        for(PurchaseOrderLineItem__c item:productsToPurchase){
            productsToPurchaseItem.add(item.Product__c);
        }
 
          purchaseOrderLineItemsdisplayPopUp = true;
         if(productsToPurchaseItem.contains(productId)){
             OrderDisplayPopUp = true;
       
            for(PurchaseOrderLineItem__c productInLineItem : productsToPurchase){
                if(productInLineItem.Product__c == productId){
                    productInLineItem.Quantity__c = ++productInLineItem.Quantity__c;
                    upsert productInLineItem;
                }
         	}   
        }
        else if(productId!=null){
             OrderDisplayPopUp = true;
        selectedProduct = [Select id,name, price__c from Product2 where id=:productId];
        PurchaseOrderLineItem__c lineItem = new PurchaseOrderLineItem__c();
        lineItem.Name = selectedProduct.Name;
        lineItem.Product__c = selectedProduct.id;
        lineItem.Quantity__c = 1;
      	lineItem.UnitPrice__c = selectedProduct.price__c; 
        lineItem.OrderId__c=order.Id;
        insert lineItem;
        ID lineItemId = lineItem.id;
        PurchaseOrderLineItem__c p = [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:lineItemId];
        productsToPurchase.add(p);
        productsToPurchaseItem.add(p.Product__c);
        }
     }    
   
     public Void removeFromCart(){
         purchaseOrderLineItemsdisplayPopUp = true;
         PurchaseOrderLineItem__c productInCart = [Select id, name,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:productId];
         Integer index = 0;
         for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
             if(purchaseOrder.Id == productInCart.Id){
                 break;
             }
               index++;
         }
         productsToPurchaseItem.remove(productsToPurchase.get(index).Product__c);
         productsToPurchase.remove(index);     
         Delete productInCart;
         if(productsToPurchase.size()==0) {
           purchaseOrderLineItemsdisplayPopUp = false;  
         }
    }   
    
    public void pay(){
       informationDisplayPopUp = true;
        upsert productsToPurchase;
    }
    
    public void confirm(){
        order.Order_Status__c=true;
        double price=0;
         for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
           price= price+purchaseOrder.TotalPrice__c;
         }
        if(order.Total_Payment__c!=null){
        order.Total_Payment__c=order.Total_Payment__c+price;
        }else{
            order.Total_Payment__c=price;
        }
        upsert order;         
        ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c];
     	OrderDisplayPopUp = true;        
		productsToPurchase.clear();
        productsToPurchaseItem.clear();
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
    }
}