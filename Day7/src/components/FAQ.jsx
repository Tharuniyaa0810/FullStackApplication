import React, { useState } from 'react';
import '../assets/css/App.css';
import SingleQuestion from './SingleQuestion';

import data from './data'
const FAQPage=()=> {
  const[questions,setQuestions]=useState(data);
  return (
    <main className='faq-main'>
        <div className='faq-container'>
            <h3>Frequently Asked Questions</h3>
            <section>
                {questions.map((question)=>{
                    return <SingleQuestion key={question.id}{...question}/>
                })}
            </section>
        </div>
    </main>
  );
}

export default FAQPage;
