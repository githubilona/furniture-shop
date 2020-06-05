/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { UserAddressService } from './user-address.service';

describe('Service: UserAddress', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserAddressService]
    });
  });

  it('should ...', inject([UserAddressService], (service: UserAddressService) => {
    expect(service).toBeTruthy();
  }));
});
