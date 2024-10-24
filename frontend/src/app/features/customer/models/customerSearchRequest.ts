export interface CustomerSearchRequest {
  natId: string;
  customerId: number;
  firstName: string;
  lastName: string;
  phoneNo: string;
  email: string;
  isActive: boolean;
  createdDate: Date;
}
