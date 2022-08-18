import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserService }  from './user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public users: User[];
  public editUser: User;
  public deleteUser: User;
  public dummyUser: User;


  constructor(private userService : UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers(): void{
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
        console.log(this.users);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(mode: string, user: User): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add'){
      button.setAttribute('data-target', '#addUserModal');
    }
    if(mode === 'edit'){
      this.editUser = user;
      button.setAttribute('data-target', '#updateUserModal');
    }
    if(mode === 'delete'){
      this.deleteUser = user;
      button.setAttribute('data-target', '#deleteUserModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddUser(addForm: NgForm): void{
    document.getElementById('add-User-form')?.click();
    this.userService.addUser(addForm.value).subscribe(
      (response: string) => {
        alert(response);
        this.getUsers();
        addForm.reset();
      }
    )
  }

  public onUpdateUser(user: User): void{
    this.userService.updateUser(user).subscribe(
      (response: string) => {
        alert(response);
        this.getUsers();
      }
    )
  }

  public onDeleteUser(userId: number): void{
    this.userService.deleteUser(userId).subscribe(
      (response: string) => {
        alert(response);
        this.getUsers();
      }
    )
  }

  public searchUsers(key: string): void{
    const result: User[] = [];
    for(const user of this.users){
      if(user.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.login.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.City.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.State.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.ZipCode.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        result.push(user);
      }
    }
    this.users = result;
    if(result.length === 0 || !key){
      this.getUsers();
    }
  }
}
