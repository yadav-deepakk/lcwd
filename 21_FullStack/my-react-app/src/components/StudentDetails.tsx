import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { BASE_URL_STUDENT_V1 } from '../constants/constants';
import type { Student } from '../models/Student';

const StudentDetails = () => {

  const {id} = useParams(); 
  const [studentData, setStudentData] = useState<Student | null >(null); 

  useEffect(() => { 
    fetchStudentData(); 
  }, [])

  const fetchStudentData = () => {
    console.log("fetching student: id ", id); 
    fetch(`${BASE_URL_STUDENT_V1}/${id}`)
    .then(response => response.json())
    .then(data => setStudentData(data))
    .catch(err => console.log("error: " + err)); 
  }

  if(studentData) {
    return <>
      <div>StudentDetails: {id}</div>
      <div>
        <div>name: {studentData['name']}</div>
        <div>username: {studentData['username']}</div>
        <div>email: {studentData['email']}</div>
      </div>
    </>
  }else {
    <>
      <div>StudentDetails Loading...</div>
    </>
  }
}

export default StudentDetails; 

