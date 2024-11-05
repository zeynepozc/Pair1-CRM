
export interface GetCustomerAccountsByCustomerIdResponse {
  customerId: number;
  accountStatus: string;
  accountNumber: string;
  accountName: string;
  accountType: string;
  accountDescription: string;
  productList: Product[];
  expanded?: boolean;
}

interface Product {
  id: number,
  name: string,
  description: string,
  price: number,
  stockQuantity:number,
  active: boolean
}


