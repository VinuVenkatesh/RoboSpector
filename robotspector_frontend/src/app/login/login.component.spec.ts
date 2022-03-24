import { async,ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule} from '@angular/forms';
describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientModule, ReactiveFormsModule],
      declarations: [ LoginComponent ],
    })
    
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('on Submit should exist',() =>{
    expect(component.loginSubmit).toBeTruthy()
  })
  
  it('ngOnInit method should exist', () => {
    expect(component.ngOnInit).toBeTruthy()
  })

  it('onSubmit() should verify form is invalid ', () => {
    component.form.value.username = '';
    component.form.value.password = '';
    component.loginSubmit();
    expect(component.submitMessage).toEqual('Username or password invalid');
  });

  it('loginSubmit() should verify form is valid', () => {
    component.ngOnInit();
    component.form.value.username = 'BobbyBoy8!';
    component.form.value.password = 'CastleFrechFry22!';
    component.loginSubmit();
    expect(component.submitMessage).toEqual('');
  });
 
});

