import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router';
import { BASE_URL_STUDENT_V1 } from '../constants/constants';
import type { Student } from '../models/Student';

const StudentDetails = () => {

  const navigate = useNavigate(); 
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

  const handleEdit = (id?: string) => {
    if (!id) return;
    // alert("Edit button was pressed")
    navigate("/edit-student?id=" + id)
  }

  const handleDelete = (id?: String) => {
    let input = prompt("Are you sure? Want to delete the student? (Y/n)")
    if(confirm("your choice was: " + input)) {
      // console.log("go for deletion.")

      fetch(`${BASE_URL_STUDENT_V1}/${id}`,{ method: "DELETE" })
      .then(response => {
        if(response.ok)
          console.log("method returned ok!, deletion succesful.")
        return response.json(); 
      })
      .then(data => console.log(data))
      .then(error => console.error(error))
    } else {
      // abort the delete.
      console.error("deletion is aborted!")
    }
  }

  if(studentData) {
    return <>
      <div>StudentDetails: {id}</div>
      <div>
        <div>name: {studentData['name']}</div>
        <div>username: {studentData['username']}</div>
        <div>email: {studentData['email']}</div>
      </div>
      <button onClick={() => handleEdit(id)}>Edit</button>
      <button onClick={() => handleDelete(id)}>Delete</button>
    </>
  }else {
    <>
      <div>StudentDetails Loading...</div>
    </>
  }
}

export default StudentDetails; 
