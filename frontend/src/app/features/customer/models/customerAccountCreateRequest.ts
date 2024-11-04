export interface CustomerAccountCreateRequest {
  customerId: number;
  accountStatus: string;
  accountName: string;
  accountType: string;
  accountDescription: string;
}
