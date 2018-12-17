import { ITeacher } from 'app/shared/model//teacher.model';

export const enum EducationType {
    PRIMARY = 'PRIMARY',
    SECONDARY = 'SECONDARY',
    HIGHER_SECONDARY = 'HIGHER_SECONDARY'
}

export interface ISchool {
    id?: number;
    name?: string;
    eduType?: EducationType;
    noOfRooms?: number;
    teachers?: ITeacher[];
}

export class School implements ISchool {
    constructor(
        public id?: number,
        public name?: string,
        public eduType?: EducationType,
        public noOfRooms?: number,
        public teachers?: ITeacher[]
    ) {}
}
