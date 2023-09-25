import React from 'react';
import { BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill, BsFillBellFill } from 'react-icons/bs';
import { PieChart, Pie, Cell, ResponsiveContainer, LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import '../assets/css/Content.css';

const Content = () => {
  const data = [
    { name: 'TRANSACTIONS', value: 300 },
    { name: 'CATEGORIES', value: 12 },
    { name: 'USERS', value: 33 },
    { name: 'FEEDBACK', value: 42 },
  ];

  // Define custom colors for the pie chart sections
  const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042'];

  const lineChartData = [
    {
      name: 'Sunday',
      uv: 4000,
      pv: 2400,
      amt: 2400,
    },
    {
      name: 'Monday',
      uv: 3000,
      pv: 1398,
      amt: 2210,
    },
    {
      name: 'Tuesday',
      uv: 2000,
      pv: 9800,
      amt: 2290,
    },
    {
      name: 'Wednesday',
      uv: 2780,
      pv: 3908,
      amt: 2000,
    },
    {
      name: 'Thursday',
      uv: 1890,
      pv: 4800,
      amt: 2181,
    },
    {
      name: 'Friday',
      uv: 2390,
      pv: 3800,
      amt: 2500,
    },
    {
      name: 'Saturday',
      uv: 3490,
      pv: 4300,
      amt: 2100,
    },
  ];

  return (
   <div>
      <div className='new-main-title'>
        <h3>DASHBOARD</h3>
      </div>

      <div className='new-main-cards'>
        {data.map((item, index) => (
          <div className='new-card' key={index}>
            <div className='new-card-inner'>
              <h3>{item.name}</h3>
              {index === 0 ? (
                <BsFillArchiveFill className='new-card_icon' />
              ) : index === 1 ? (
                <BsFillGrid3X3GapFill className='new-card_icon' />
              ) : index === 2 ? (
                <BsPeopleFill className='new-card_icon' />
              ) : (
                <BsFillBellFill className='new-card_icon' />
              )}
            </div>
            <h1>{item.value}</h1>
          </div>
        ))}
      </div>

      <div className='new-chart-content'>
        <ResponsiveContainer width={750} height={350}>
          <PieChart>
            <Pie
              dataKey='value'
              data={data}
              cx='50%'
              cy='50%'
              outerRadius={80}
              fill='#8884d8'
              label
            >
              {data.map((entry, index) => (
                <Cell key={`new-cell-${index}`} fill={COLORS[index % COLORS.length]} />
              ))}
            </Pie>
          </PieChart>
        </ResponsiveContainer>

        <ResponsiveContainer width='50%' height={300}>
          <LineChart
            width={500}
            height={300}
            data={lineChartData}
            margin={{
              top: 5,
              right: 40,
              left: 20,
              bottom: 5,
            }}
          >
            <CartesianGrid strokeDasharray='3 3' />
            <XAxis dataKey='name' />
            <YAxis />
            <Tooltip />
            <Legend />
            <Line type='monotone' dataKey='pv' stroke='#8884d8' activeDot={{ r: 8 }} />
            <Line type='monotone' dataKey='uv' stroke='#82ca9d' />
          </LineChart>
        </ResponsiveContainer>
      </div>
      </div>
  );
};

export default Content;
