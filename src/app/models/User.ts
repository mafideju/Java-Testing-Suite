export interface User {
  name: string;
  lastName: string;
  age: number;
  mainLanguage: string;
  active?: boolean;
  contact?: {
    email?: string;
    phone?: string;
  };
  image?: string;
  hide?: boolean;
  joinedAt?: Date;
}
