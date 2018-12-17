import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TempSharedModule } from 'app/shared';
import {
    SchoolComponent,
    SchoolDetailComponent,
    SchoolUpdateComponent,
    SchoolDeletePopupComponent,
    SchoolDeleteDialogComponent,
    schoolRoute,
    schoolPopupRoute
} from './';

const ENTITY_STATES = [...schoolRoute, ...schoolPopupRoute];

@NgModule({
    imports: [TempSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [SchoolComponent, SchoolDetailComponent, SchoolUpdateComponent, SchoolDeleteDialogComponent, SchoolDeletePopupComponent],
    entryComponents: [SchoolComponent, SchoolUpdateComponent, SchoolDeleteDialogComponent, SchoolDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TempSchoolModule {}
