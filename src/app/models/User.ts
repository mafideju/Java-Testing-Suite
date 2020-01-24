export interface User {
  name: string;
  lastName: string;
  age: number;
  active?: boolean;
  contact?: {
    email?: string;
    phone?: string;
  };
  image?: string;
  hide?: true;
}
