export interface GetCustomerAccountsByCustomerIdResponse {
  customerId: number;
  accountStatus: string;
  accountNumber: string;
  accountName: string;
  accountType: string;
  accountDescription: string;
  products: [];
  expanded?: boolean;
}
