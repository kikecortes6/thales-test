import {
  HttpEvent,
  HttpHandler,
  HttpRequest,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable()
export class HttpErrorInterceptor extends HttpErrorResponse {
  constructor(private toastrService: ToastrService) { super(toastrService); }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let { url } = request;
    console.log(url);
    url = /^https?:\/\//.test(url) ? url : environment.urlBase + url;
    const req: any = { url };

    return next.handle(request.clone(req))
      .pipe(
        catchError((error: HttpErrorResponse) => {
          let errMsg = '';
          let errorType = 'Error';
          console.log(error);
          if (error.error instanceof ErrorEvent) {
            errMsg = `Error!!`;
          } else {

            if (error.status === 0) {
              errMsg = `${error.status}, ` + 'No hay conexión al servidor';
            }
            this.toastrService.error(errMsg, errorType, { closeButton: true });
          }
          return throwError(errMsg);
        })
      );
  }


}
