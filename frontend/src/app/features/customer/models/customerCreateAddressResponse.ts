export interface CustomerCreateAddressResponse{
    id: number,
    customerId: number,
    name: string,
    city: string,
    district: string,
    neighborhood: string,
    postalCode: string,
    houseNo: string,
    description: string,
    primaryAddress: boolean
}