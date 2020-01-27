import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Post } from '../models/Post';

const httpOpts = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class PostService {
  postsURL: string = `https://jsonplaceholder.typicode.com/posts`
  
  constructor(private _http: HttpClient) { }
  
  getPosts(): Observable<Post[]> {
    return this._http.get<Post[]>(this.postsURL);
  }

  savePost(post: Post): Observable<Post> {
    return this._http.post<Post>(this.postsURL, post, httpOpts);
  }
}
