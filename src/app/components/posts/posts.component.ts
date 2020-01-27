import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PostService } from '../../services/post.service'
import { Post } from 'src/app/models/Post';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  posts: Post[];
  post: Post;

  @Output() addPost: EventEmitter<Post> = new EventEmitter();

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.posts = [];
  }
  
  getPosts() {
    this.postService.getPosts().subscribe(posts => {
        this.posts = posts;
      }
    )
  }

  newPost(title, body) {
    this.postService.savePost({title, body} as Post).subscribe(post => {
      console.log('POST -=>', post);
      this.addPost.emit(post);
      this.posts.unshift(post);
      // setTimeout(() => {
      //   this.posts.unshift(post);
      // }, 1000);
    });
  }
}
