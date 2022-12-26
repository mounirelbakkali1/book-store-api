import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'bs-book-form',
  templateUrl: './book-form.component.html',
  styles: [],
})
export class BookFormComponent {
  book = {
    id: 1,
    title: "mounir's Book for 2023",
    description:
      'Le lorem ipsum est, en imprimerie, une suite detion utralement, on u',
    unitCost: 99.98,
    isbn: '8-7832561019823-2022',
    publicationDate: 1669849200000,
    numberOfPages: 129,
    imageURL: 'https://m.media-amazon.com/images/I/61HUuiDH+0L.jpg',
    language: 'FR',
    author_id: {
      id: 1,
      firstName: 'Mounir',
      lastName: 'El Bakkali',
      dateOfBirth: 1064448000000,
      bio: 'Full stack spring angular developer and author',
      age: 0,
      preferdLanguage: 'AR',
      bookList: null,
    },
  };
}
